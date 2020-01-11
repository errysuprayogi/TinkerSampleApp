package com.tokopedia.sample

import android.Manifest
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.downloader.Status
import com.tencent.tinker.lib.tinker.TinkerInstaller
import kotlinx.android.synthetic.main.activity_main.*
import com.tokopedia.sample.utils.Utils
import java.io.File


class MainActivity : AppCompatActivity() {

    var downloadIdOne = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text.text = "Fixing a crash"

        askForRequiredPermissions()
        load_btn.setOnClickListener {
            TinkerInstaller.onReceiveUpgradePatch(
                applicationContext,
                Environment.getExternalStorageDirectory()
                    .absolutePath + "/Download/patch_signed_7zip.apk"
            )
        }

        click_btn.setOnClickListener {
            Toast.makeText(this, "Hello I'am Fixed", Toast.LENGTH_LONG).show()
        }
    }

    private fun askForRequiredPermissions() {
        if (Build.VERSION.SDK_INT < 23) {
            return
        }
        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                0
            )
        }
    }

    private fun hasRequiredPermissions(): Boolean {
        return if (Build.VERSION.SDK_INT >= 16) {
            val res = ContextCompat.checkSelfPermission(
                this.applicationContext,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            res == PackageManager.PERMISSION_GRANTED
        } else { // When SDK_INT is below 16, READ_EXTERNAL_STORAGE will also be granted if WRITE_EXTERNAL_STORAGE is granted.
            val res = ContextCompat.checkSelfPermission(
                this.applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            res == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun patchDownloader(patchUrl: String) {
        if (Status.RUNNING === PRDownloader.getStatus(downloadIdOne)) {
            PRDownloader.pause(downloadIdOne)
            return
        }
        if (Status.PAUSED === PRDownloader.getStatus(downloadIdOne)) {
            PRDownloader.resume(downloadIdOne)
            return
        }
        val progressBarDialog = ProgressDialog(this@MainActivity)
        progressBarDialog.setTitle("Patch Downloading...")
        progressBarDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressBarDialog.setCanceledOnTouchOutside(false)
        progressBarDialog.isIndeterminate = true
        //setting the OK Button
        progressBarDialog.setButton(
            DialogInterface.BUTTON_POSITIVE,
            "Background"
        ) { dialog, whichButton -> showToast("Downloading continue in background") }
        //set the Cancel button
        progressBarDialog.setButton(
            DialogInterface.BUTTON_NEGATIVE,
            "Cancel"
        ) { dialog, whichButton -> PRDownloader.cancel(downloadIdOne) }
        //initialize the dialog..
        progressBarDialog.progress = 0
        //show the dialog
        progressBarDialog.show()

        downloadIdOne = PRDownloader.download(
            patchUrl,
            Utils.getRootDirPath(this@MainActivity),
            "patch_signed_7zip.apk"
        )
            .build()
            .setOnStartOrResumeListener { progressBarDialog.isIndeterminate = false }
            .setOnPauseListener { }
            .setOnCancelListener {
                downloadIdOne = 0
                progressBarDialog.progress = 0
                progressBarDialog.dismiss()
            }
            .setOnProgressListener { progress ->
                val progressPercent =
                    progress.currentBytes * 100 / progress.totalBytes
                progressBarDialog.progress = progressPercent.toInt()
                //showToast(""+(int)progressPercent);
            }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    showToast("Patch Download Complete")
                    progressBarDialog.dismiss()
                    // load patch
                    loadPatch()
                }

                override fun onError(error: com.downloader.Error?) {
                    showToast("Download Error! something went wrong try again, try again.")
                    downloadIdOne = 0
                    progressBarDialog.progress = 0
                    progressBarDialog.dismiss()
                    deleteErrorFile(patchUrl)
                }

            })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun getPatchFilePath(videoURl: String): String? {
        val uri: Uri = Uri.parse(videoURl)
        return uri.lastPathSegment
    }

    private fun deleteErrorFile(path: String) {
        val file = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File(
                getExternalFilesDirs(null)[0],
                getPatchFilePath(path).toString() + ".temp"
            )
        } else {
            TODO("VERSION.SDK_INT < KITKAT")
        }
        if (file.exists()) {
            file.delete()
            if (file.exists()) {
                showToast("Not clear")
            } else {
                showToast("Session clear")
            }
        }
    }

    private fun loadPatch() {
        if (checkPatchExist()) {
            showToast("Patch applying...")
            val file = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                File(getExternalFilesDirs(null)[0], "patch_signed_7zip.apk")
            } else {
                TODO("VERSION.SDK_INT < KITKAT")
            }
            TinkerInstaller.onReceiveUpgradePatch(
                applicationContext,
                file.absolutePath
            ) //Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk"
        } else {
            showToast("Something wrong, patch file not found!")
        }
    }

    private fun checkPatchExist(): Boolean {
        val file = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File(getExternalFilesDirs(null)[0], "patch_signed_7zip.apk")
        } else {
            TODO("VERSION.SDK_INT < KITKAT")
        }
        return file.exists()
    }

    private fun seting(){
        Log.d("TAG", "this is setting")
    }
}

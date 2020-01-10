message("Hello World!")
# Warn when there is a big PR
if git.lines_of_code > 500
    warn("Big PR")
end

# Mainly to encourage writing up some reasoning about the PR, rather than
# just leaving a title
if github.pr_body.length < 5
  fail "Please provide a summary in the Pull Request description"
end

# Give a warning when a PR is over expected size
warn("This PR is quite a big one! Try splitting this into separate tasks next time 🙂") if git.lines_of_code > 500

message("Thank you for your work @#{github.pr_author} 🎉 You might find a few suggestions from me below 😉")

# ktlint
github.dismiss_out_of_range_messages
checkstyle_format.base_path = Dir.pwd
checkstyle_format.report "app/build/reports/ktlint/ktlintMainSourceSetCheck.xml"

# AndroidLint
android_lint.report_file = "app/build/reports/lint-results.xml"
android_lint.gradle_task = "runChecksForDanger"
android_lint.filtering = true
android_lint.severity = "Error"
android_lint.lint(inline_mode: true)

# Apk Stat
apkstats.apk_filepath='app/build/output/apk/liveDev/debug/app-live-dev-debug.apk'
apkstats.file_size #=> Fixnum
apkstats.download_size #=> Fixnum
apkstats.required_features #=> Array<String> | Nil
apkstats.non_required_features #=> Array<String> | Nil
apkstats.permissions #=> Array<String> | Nil
apkstats.min_sdk #=> String | Nil
apkstats.target_sdk #=> String | Nils
apkstats.reference_count #=> Fixnum
apkstats.dex_count #=> Fixnum
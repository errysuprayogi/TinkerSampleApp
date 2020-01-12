## METHODS DECLARATION ##
def checkForFileAndroid(file)
  ext = File.extname(file)
  case ext
  # Warn when a file .gradle is modified
  when ".gradle"
    message("`#{file}` was modified")
  end
  # Warn when a FileManifest.xml is modified
  message("`#{file}` was modified") if file =~ /AndroidManifest\.xml/
end

def exceptionMessages(file)
  if File.file?(file)
    message("Something went wrong checking `#{file}`. Check your Dangerfile")
  else
    message("One of modified files could not be read, does it really exist?")
  end
end

# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
if github.pr_title.include? "[WIP]"
    warn("PR is classed as Work in Progress")
end

# If these are all empty something has gone wrong, better to raise it in a comment
if git.modified_files.empty? && git.added_files.empty? && git.deleted_files.empty?
  warn "This PR has no changes at all, this is likely an issue during development."
end

# Ensure a clean commits history
if git.commits.any? { |c| c.message =~ /^Merge branch '#{github.branch_for_base}'/ }
  warn "Please rebase to get rid of the merge commits in this PR"
end

# Mainly to encourage writing up some reasoning about the PR, rather than
# just leaving a title
#if github.pr_body.length < 120
#  warn "Please provide a summary in the Pull Request description"
#end

# Ensure that the PR title follows the convention
# if !(github.pr_title =~ /\[TASKID-([0-9])+\](.*)/)
#  warn "The Pull Request title does not follow the convention [TASKID-0000] PR Title text"
#end

#Check modified files, apply rules to them
git.modified_files.each do |file|
  begin
    checkForFileAndroid(file)
  rescue
    exceptionMessages(file)
  end
end

# Give a warning when a PR is over expected size
warn("This PR is quite a big one! Try splitting this into separate tasks next time 🙂") if git.lines_of_code > 500

message("Thank you for your work @#{github.pr_author} 🎉 You might find a few suggestions from me below 😉")

# github.dismiss_out_of_range_messages

# ktlint
# checkstyle_format.base_path = Dir.pwd
# checkstyle_format.report "app/build/reports/ktlint/ktlintMainSourceSetCheck.xml"

# AndroidLint
android_lint.report_file = "app/build/reports/lint-results.xml"
android_lint.skip_gradle_task = true
android_lint.filtering = true
# android_lint.severity = "Error"
android_lint.lint(inline_mode: true)

# ApkStats
# apkstats.apk_filepath="app/build/outputs/apk/liveDev/debug/app-live-dev-debug.apk"
# apkstats.file_size #=> Fixnum

github.review.start
if android_lint.count > 0
  github.review.fail("I can fail your PR in a moment")
else
  github.review.message("Nice work! Approved")
end
github.review.submit
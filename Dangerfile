# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500

# Give a warning if the PR description is empty
warn("Please provide a PR description") if github.pr_body.length < 5

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
# android_lint.filtering = true
# android_lint.severity = "Error"
android_lint.lint(inline_mode: true)

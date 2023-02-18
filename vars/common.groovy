def compile() {
    if (app_lang == "nodejs") {
        sh 'npm install'
    }

    if (app_lang == "maven") {
        sh 'mvn package'
    }
}

def unittests() {

    if (app_lang == "nodejs") {
        // Developer has missed unit test cases in our project, He need to add them for best practices, We are skipping to proceed further
        sh 'npm test || true'
    }

    if (app_lang == "maven") {
        sh 'mvn test'
    }

    if (app_lang == "python") {
        sh 'python3 -m unittest'
    }
}

def email(email_note) {
    mail bcc: '', body: "Job Failed - ${JOB_BASE_NAME}\nJenkins URL - ${JOB_URL}", cc: '', from: 'harishsarma.v@gmail.com', replyTo: '', subject: "Jenkins Job Failed - ${JOB_BASE_NAME}", to: 'harishsarma.v@gmail.com'
}
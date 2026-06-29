pipeline {
    agent any

    environment {
        // Change this to the email address where you want to receive alerts
        ALERT_EMAIL = 'sample.com'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                // Use 'package' to run tests AND create the jar file
                sh 'mvn clean package'
            }
        }
    }
    
    post {
        success {
            // Saves the jar into Jenkins build history
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            // Send email if the build fails
            mail to: "${env.ALERT_EMAIL}",
                 subject: "Failed Pipeline: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build failed. You can check the logs at ${env.BUILD_URL}"
        }
        always {
            // Publishes test results
            junit '**/target/surefire-reports/*.xml'
        }
    }
}

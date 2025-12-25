pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh '''
                STATUS=$(curl -k -s -o /dev/null -w "%{http_code}" https://example.com/a)
                echo "Status: $STATUS"
                [ "$STATUS" = "200" ]
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy çalışıyor..."
            }
        }
    }
}

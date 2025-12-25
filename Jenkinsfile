pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy çalışıyor..."
            }
        }
    }
}

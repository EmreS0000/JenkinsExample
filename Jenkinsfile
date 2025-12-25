pipeline {
    agent any

    stages {
        stage('Health Check') {
            when {
                branch 'main'
            }
            steps {
                sh '''
                javac -version
                javac src/main/java/com/example/HealthCheckMain.java
                java -cp src/main/java com.example.HealthCheckMain
                '''
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying application..."
                echo "Deploy successful!"
            }
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Health Check') {
            when {
                anyOf {
                    branch 'main'
                    expression { env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main' }
                }
            }
            steps {
                sh '''
                javac -version
                javac src/test/java/com/example/HealthCheckTest.java
                java -cp src/test/java com.example.HealthCheckTest
                '''
            }
        }

        stage('Deploy') {
            when {
                anyOf {
                    branch 'main'
                    expression { env.BRANCH_NAME == 'main' || env.GIT_BRANCH == 'main' || env.GIT_BRANCH == 'origin/main' }
                }
            }
            steps {
                echo "Deploy çalışıyor..."
            }
        }
    }
}

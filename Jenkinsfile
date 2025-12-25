pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                script {
                    def branch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: ''
                    def isMain = branch == 'main' || branch == 'origin/main' || branch == 'refs/heads/main'
                    if (isMain) {
                        sh '''
                        javac -version
                        javac src/test/java/com/example/HealthCheckTest.java
                        java -cp src/test/java com.example.HealthCheckTest
                        '''
                    } else {
                        echo "Skipping Health Check on branch: ${branch}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def branch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: ''
                    def isMain = branch == 'main' || branch == 'origin/main' || branch == 'refs/heads/main'
                    if (isMain) {
                        echo "Deploying application..."
                        echo "Deploy successful!"
                    } else {
                        echo "Skipping Deploy on branch: ${branch}"
                    }
                }
            }
        }
    }
}

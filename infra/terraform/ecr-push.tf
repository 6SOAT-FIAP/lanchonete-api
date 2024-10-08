resource "aws_ecr_repository" "repository_lanchonete-api" {
  name                 = "lanchonete-api"
  image_tag_mutability = "MUTABLE"

  image_scanning_configuration {
    scan_on_push = false
  }

  force_delete = true
}

# Definição de um recurso de execução local para fazer o push da imagem
resource "null_resource" "push_image_to_ecr" {
  provisioner "local-exec" {
    command = "aws ecr get-login-password | docker login --username AWS --password-stdin 578360598759.dkr.ecr.sa-east-1.amazonaws.com && docker build -t 578360598759.dkr.ecr.sa-east-1.amazonaws.com/lanchonete-api:latest ../../ && docker push 578360598759.dkr.ecr.sa-east-1.amazonaws.com/lanchonete-api:latest"
  }
  depends_on = [aws_ecr_repository.repository_lanchonete-api]
}

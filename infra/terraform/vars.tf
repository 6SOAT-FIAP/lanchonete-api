variable "projectName" {
  default = "lanchonete-api"
}

variable "tags" {
  type    = map(string)
  default = {
    App      = "lanchonete-api",
    Ambiente = "Desenvolvimento"
  }
}

variable "accessKey" {
  description = "Access Key Id"
  type        = string
  sensitive   = true
}

variable "secretKey" {
  description = "Access Key Secret"
  type        = string
  sensitive   = true
}

variable "defaultRegion" {
  description = "Aws Region"
  type        = string
  sensitive   = true
}

variable "accountId" {
  description = "Aws Account Id"
  type        = string
  sensitive   = true
}

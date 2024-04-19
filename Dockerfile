FROM mcr.microsoft.com/powershell:latest

COPY TerceiraAtividade.ps1 /scripts/

CMD ["pwsh", "-File", "/scripts/TerceiraAtividade.ps1"]



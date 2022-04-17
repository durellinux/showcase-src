FROM mcr.microsoft.com/dotnet/aspnet:6.0
WORKDIR /app
EXPOSE 80
EXPOSE 443

WORKDIR /app
COPY ./dist/docker .
ENTRYPOINT ["dotnet", "DemoGenerator.dll"]

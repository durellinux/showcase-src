using DemoGenerator.Resources.Demo;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddSingleton<DemoService, DemoService>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    
}

app.UseSwagger(c =>
{
    c.RouteTemplate = "demoservice/swagger/{documentname}/swagger.json";
});


app.UseSwaggerUI(c =>
{
    c.SwaggerEndpoint("/demoservice/swagger/v1/swagger.json", "Demo Generator");
    c.RoutePrefix = "demoservice/swagger";
});

// app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
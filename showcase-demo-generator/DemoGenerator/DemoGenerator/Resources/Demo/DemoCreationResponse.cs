namespace DemoGenerator.Resources.Demo;

public class DemoCreationResponse
{
    private String domainName;
    private String domainUrl;
    private String username;
    private String password;

    public DemoCreationResponse(string domainName, string domainUrl, string username, string password)
    {
        this.domainName = domainName;
        this.domainUrl = domainUrl;
        this.username = username;
        this.password = password;
    }

    public string DomainName => domainName;

    public string DomainUrl => domainUrl;

    public string Username => username;

    public string Password => password;
}
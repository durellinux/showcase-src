using ShowcaseOrganizationServiceClient.Api;
using ShowcaseOrganizationServiceClient.Model;

namespace DemoGenerator.Resources.Demo;

public class DemoService
{
    private IOrganizationResourceApi _organizationResourceApi;
    private UserResourceApi _userResourceApi;

    public DemoService(IConfiguration configuration)
    {
        string basePath = configuration["ApiClients:OrganizationService"];
        _organizationResourceApi = new OrganizationResourceApi(basePath);
        _userResourceApi = new UserResourceApi(basePath);
    }

    public DemoCreationResponse createDemo(String demoName)
    {
        OrganizationRequest request = new OrganizationRequest();
        request.Name = demoName;
        OrganizationResponse organization = _organizationResourceApi.OrganizationsserviceApiV1OrganizationsPost(request);

        // UserRequest userRequest = generateRandomUser(organization.Name);
        // UserResponse userResponse = _userResourceApi.ApiV1UsersPost(userRequest);

        DemoCreationResponse response = new DemoCreationResponse(demoName, demoName, "User", "Password");
        return response;
    }

    private UserRequest generateRandomUser(String organizationName)
    {
        String name = "Marc";
        String surname = "Landers";
        String email = (name + " " + surname + " " + organizationName + ".mail").Replace(" ", ".");
        
        UserRequest user = new UserRequest();
        user.Name = name;
        user.Surname = surname;
        user.Email = email;

        return user;
    }
}
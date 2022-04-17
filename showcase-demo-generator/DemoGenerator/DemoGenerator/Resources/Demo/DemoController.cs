using Microsoft.AspNetCore.Mvc;

namespace DemoGenerator.Resources.Demo;

[ApiController]
[Route("/demoservice/api/v1/demo/")]
public class DemoController : ControllerBase
{
    private DemoService _demoService;

    public DemoController(DemoService demoService)
    {
        _demoService = demoService;
    }

    [Route("{demoName}")]
    [HttpPost]
    public ActionResult<DemoCreationResponse> CreateDemo(string demoName)
    {
        return _demoService.createDemo(demoName);
    }
}
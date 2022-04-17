import { DemoApi } from "showcase-demo-generator-client";
import axios from "axios";

class DemoApiProvider {
  private demoApi?: DemoApi = undefined;

  public getDemoApi(): DemoApi {
    if (this.demoApi == undefined) {
      this.demoApi = this.setupDemoApi();
    }

    return this.demoApi;
  }

  private setupDemoApi(): DemoApi {
    const configuration = {};
    const axiosInstance = axios.create();
    const baseUrl = "/demoservice";
    return new DemoApi(configuration, baseUrl, axiosInstance);
  }
}

export default new DemoApiProvider();

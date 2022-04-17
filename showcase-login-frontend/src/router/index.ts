import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import CredentialsLogin from "@/views/CredentialsLogin.vue";

const entryPoint = "/login";

const routes: Array<RouteRecordRaw> = [
  {
    path: entryPoint + "/credentials",
    name: "CredentialsLogin",
    component: CredentialsLogin,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

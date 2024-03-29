import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Onboarding from "@/views/Onboarding.vue";

const entryPoint = "/onboarding";

const routes: Array<RouteRecordRaw> = [
  {
    path: entryPoint + "/start",
    name: "Start",
    component: Onboarding,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});


export default router;

<template>
  <div class="onboarding-page">
    <div v-if="isCreating">Creation in progress</div>
    <div v-else class="onboarding-container">
      <h1>Insert the name of your domain</h1>
      <input placeholder="Domain here" type="text" v-model="domainName" />
      <button @click="createDomain">Create</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import DemoApiProvider from "@/api/DemoApiProvider";

const demoApi = DemoApiProvider.getDemoApi();

interface OnboardingData {
  domainName: string;
  isCreating: boolean;
}

export default defineComponent({
  name: "Onboarding",
  data(): OnboardingData {
    return {
      domainName: "",
      isCreating: false,
    };
  },
  methods: {
    async createDomain() {
      try {
        this.isCreating = true;
        await demoApi.apiV1DemoDemoNamePost(this.domainName);
      } catch (error) {
        console.log(error);
      } finally {
        this.isCreating = false;
      }
    },
  },
});
</script>

<style scoped>
.onboarding-page {
  width: 100vw;
  height: 100vh;
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}

.onboarding-container {
  display: flex;
  flex-direction: column;
  width: 70%;
  height: 40%;
  background: lightgray;
  border-color: darkgray;
  border-style: solid;
  border-radius: 10px;
  align-items: center;
}
</style>

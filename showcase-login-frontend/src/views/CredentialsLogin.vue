<template>
  <input type="text" placeholder="Username" />
  <input type="password" placeholder="Password" />
  <button>Login</button>
  <router-link :to="{ path: '/onboarding/start', baseUrl: '' }" v-slot="{ navigate }">
    <button @click="navigate">Register</button>
  </router-link>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "CredentialsLogin",
});
</script>

<style scoped></style>

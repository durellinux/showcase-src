// GcAutocomplete component.
// The component has a search bar and a dropdown list.
// The dropdown list is populated with the results of the search.
// The component accept a search function as a prop that returns a promise that resolves to an array of strings.
// The component emits an event when an item is selected with the item as a payload.
// The results are displayed in the dropdown list.
// The user can select a result from the dropdown list.
// When the item is selected, emit the event and set the search text to the selected item and hide the dropdown list.

<template>
  <div class="autocomplete">
    <div class="search-bar">
      <input
          type="text"
          class="search-input"
          :placeholder="placeholder"
          v-model="searchText"
      />
    </div>
    <div class="dropdown" v-if="showDropdown">
      <div class="dropdown-item" v-for="item in results" :key="item" @click="onSelect(item)">
        {{ item }}
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, watch } from "vue";

const searchText = ref("");
const results = ref<string[]>([]);
const showDropdown = ref(false);
const placeholder = "Search";
const emits = defineEmits(['selected']);

const onSelect = (item: string) => {
  searchText.value = item;
  showDropdown.value = false;
  emits("selected", item);
};

// Props of the component
const props = defineProps<{
  search: (searchText: string) => Promise<string[]>;
}>();

// Watch for changes in the search text
watch(searchText, async (newSearchText) => {
  if (newSearchText) {
    results.value = await props.search(newSearchText);
    showDropdown.value = true;
  } else {
    results.value = [];
    showDropdown.value = false;
  }
});

</script>

<style lang="scss" scoped>
@import '../design_system_tokens.scss';

.autocomplete {
  position: relative;
}

.search-bar {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  border: 1px solid $color-primary;
  border-radius: 0.25rem;
  padding: 0.5rem;
}

.search-input {
  @include typography-body-1;
  color: $color-text-primary;
  background-color: transparent;
  border: none;
  outline: none;
  width: 100%;
}

.dropdown {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  background-color: white;
  border: 1px solid $color-primary;
  border-radius: 0.25rem;
  padding: 0.5rem;
  z-index: 1;
}

.dropdown-item {
  @include typography-body-1;
  color: $color-text-primary;
  padding: 0.5rem;
  cursor: pointer;
}

.dropdown-item:hover {
  background-color: $color-accent-lightest;
}
</style>

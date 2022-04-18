import {TextInput} from "../lib-components";

export default {
    title: 'Inputs/Text Input',
    component: TextInput,
};

export const Enabled = () => ({
    components: { TextInput },
    template: '<text-input />',
});

export const Disabled = () => ({
    components: { TextInput },
    template: '<text-input disabled />',
});
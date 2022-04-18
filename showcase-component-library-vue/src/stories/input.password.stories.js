import {PasswordInput} from "../lib-components";

export default {
    title: 'Inputs/Password Input',
    component: PasswordInput,
};

export const Enabled = () => ({
    components: { PasswordInput },
    template: '<password-input />',
});

export const Disabled = () => ({
    components: { PasswordInput },
    template: '<password-input disabled />',
});
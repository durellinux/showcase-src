// Storybook stories for GcButtonPrimary

import { storiesOf } from '@storybook/vue3';
import GcButtonFilled from '@/components/inputs/buttons/GcButtonFilled.vue';

storiesOf('Inputs/Buttons', module)
    .add('GcButtonFilled default', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled>Primary</GcButtonFilled>',
    }))
    .add('GcButtonFilled primary', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled color="primary">Primary</GcButtonFilled>',
    }))
    .add('GcButtonFilled accent', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled color="accent">Accent</GcButtonFilled>',
    }))
    .add('GcButtonFilled error', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled color="error">Error</GcButtonFilled>',
    }))
    .add('GcButtonFilled warning', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled color="warning">Warning</GcButtonFilled>',
    }))
    .add('GcButtonFilled custom colors', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled color="custom" style="--color-custom: #FF00FF; --color-custom-text: #FFFFFF">Custom</GcButtonFilled>',
    }))
    .add('GcButtonFilled disabled', () => ({
        components: { GcButtonFilled },
        template: '<GcButtonFilled disabled>Disabled</GcButtonFilled>',
    }));

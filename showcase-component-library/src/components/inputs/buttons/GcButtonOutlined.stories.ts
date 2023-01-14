// Storybook stories for GcButtonOutlined

import { storiesOf } from '@storybook/vue3';
import GcButtonOutlined from '@/components/inputs/buttons/GcButtonOutlined.vue';

storiesOf('Inputs/Buttons', module)
    .add('GcButtonOutlined default', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined>Default</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined primary', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined color="primary">Primary</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined accent', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined color="accent">Accent</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined error', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined color="error">Error</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined warning', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined color="warning">Warning</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined custom colors', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined color="custom" style="--color-custom: #FF00FF; --color-custom-text: #FFFFFF">Custom</GcButtonOutlined>',
    }))
    .add('GcButtonOutlined disabled', () => ({
        components: { GcButtonOutlined },
        template: '<GcButtonOutlined disabled>Disabled</GcButtonOutlined>',
    }));

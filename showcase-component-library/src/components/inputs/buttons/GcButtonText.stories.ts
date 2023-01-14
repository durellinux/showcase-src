// Storybooks stories for GcButtonText

import { storiesOf } from '@storybook/vue3';
import GcButtonText from '@/components/inputs/buttons/GcButtonText.vue';

storiesOf('Inputs/Buttons', module)
    .add('GcButtonText default', () => ({
        components: { GcButtonText },
        template: '<GcButtonText>Default</GcButtonText>',
    }))
    .add('GcButtonText primary', () => ({
        components: { GcButtonText },
        template: '<GcButtonText color="primary">Primary</GcButtonText>',
    }))
    .add('GcButtonText accent', () => ({
        components: { GcButtonText },
        template: '<GcButtonText color="accent">Accent</GcButtonText>',
    }))
    .add('GcButtonText error', () => ({
        components: { GcButtonText },
        template: '<GcButtonText color="error">Error</GcButtonText>',
    }))
    .add('GcButtonText warning', () => ({
        components: { GcButtonText },
        template: '<GcButtonText color="warning">Warning</GcButtonText>',
    }))
    .add('GcButtonText custom colors', () => ({
        components: { GcButtonText },
        template: '<GcButtonText color="custom" style="--color-custom: #FF00FF; --color-custom-text: #FFFFFF">Custom</GcButtonText>',
    }))
    .add('GcButtonText disabled', () => ({
        components: { GcButtonText },
        template: '<GcButtonText disabled>Disabled</GcButtonText>',
    }));

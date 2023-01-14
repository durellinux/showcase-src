// Storybook file for the GcButton component

import { storiesOf } from '@storybook/vue3';
import GcButtonBase from "@/components/inputs/buttons/GcButtonBase.vue";

storiesOf('Inputs/Buttons', module)
    .add('GcButtonBase', () => ({
        components: { GcButtonBase },
        template: '<GcButtonBase>button</GcButtonBase>',
    }))
    .add('GcButtonBase colors set by parent', () => ({
        components: { GcButtonBase },
        template: '<GcButtonBase style="background-color: #ff0000; color: #00ff00; border: 1px solid #0000ff;">button</GcButtonBase>',
    }))

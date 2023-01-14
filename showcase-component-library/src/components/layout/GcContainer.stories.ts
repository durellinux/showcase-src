// Stories for the Container component.

import { storiesOf } from '@storybook/vue3';
import Container from './GcContainer.vue';

storiesOf('Layout/Container', module)
    .add('Simple Container', () => ({
        components: { Container },
        template: '<Container>Container</Container>',
    }))
    .add('Container with background color', () => ({
        components: { Container },
        template: '<Container style="background-color: #eee">Container</Container>',
    }))

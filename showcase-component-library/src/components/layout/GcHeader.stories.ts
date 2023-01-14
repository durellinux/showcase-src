// Stories for the Header component.

import { storiesOf } from '@storybook/vue3';
import Header from './GcHeader.vue';

storiesOf('Layout/Header', module)
    .add('empty', () => ({
        components: { Header },
        template: `
            <Header>
            </Header>
        `,
    }))
    .add('with title slot', () => ({
        components: { Header },
        template: `
            <Header>
                <template #title>
                    My title
                </template>
            </Header>
        `,
    }))
    .add('with title and actions slot', () => ({
        components: { Header },
        template: `
            <Header>
                <template #title>
                    My title
                </template>
                <template #actions>
                    <p>Action 1</p>
                    <p>Action 2</p>
                </template>
            </Header>
        `,
    }));


// Storybook stories for Autocomplete component

import { storiesOf } from '@storybook/vue3'
import Autocomplete from './Autocomplete.vue'

storiesOf('Autocomplete', module)
    .add('default with a simple search function', () => ({
        components: { Autocomplete },
        template: `
            <Autocomplete
                :search="(query) => ['item1', 'item2', 'item3'].filter((item) => item.includes(query))"
            />
        `,
    }));

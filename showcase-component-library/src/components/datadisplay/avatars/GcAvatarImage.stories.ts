// Storybook stories for GcAvatarImage component

import { storiesOf } from '@storybook/vue3';
import GcAvatarImage from '@/components/datadisplay/avatars/GcAvatarImage.vue'

storiesOf('Data Display/Avatars', module)
    .add('GcAvatarImage', () => ({
        components: { GcAvatarImage },
        template: '<GcAvatarImage src="https://avatars.githubusercontent.com/u/5503835?v=4" />',
    }))
    .add('GcAvatarImage with name', () => ({
        components: { GcAvatarImage },
        template: '<GcAvatarImage src="https://avatars.githubusercontent.com/u/5503835?v=4" name="Durel Linux" />',
    }))

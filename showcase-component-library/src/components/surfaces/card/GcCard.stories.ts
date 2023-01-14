// Storybook file for the GcCard component

import { storiesOf } from '@storybook/vue3';
import GcCard from "@/components/surfaces/card/GcCard.vue";

storiesOf('Surfaces/Card', module)
    .add('GcCard with image and content slots', () => ({
        components: { GcCard },
        template: `
            <GcCard>
                <template #image>
                    <img src="https://picsum.photos/250/150" alt="image" />
                </template>
                <template #content>
                    <div>Content</div>
                </template>
            </GcCard>
        `,
    }))

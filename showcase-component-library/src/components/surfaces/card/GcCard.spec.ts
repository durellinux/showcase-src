// Unit tests for GcCard component

// Import the mount() method from the test utils
// and the component you want to test
import { mount } from '@vue/test-utils'
import GcCard from '@/components/surfaces/card/GcCard.vue'

describe('GcCard.vue', () => {
    test('Display the image slot', () => {
        const wrapper = mount(GcCard, {
            slots: {
                image: '<img src="https://picsum.photos/250/150" alt="image" />',
            },
        })
        expect(wrapper.find('img').exists()).toBeTruthy()
    });

    test('Display the content slot', () => {
        const wrapper = mount(GcCard, {
            slots: {
                content: '<div>Content</div>',
            },
        })
        expect(wrapper.find('div').exists()).toBeTruthy()
    });
});

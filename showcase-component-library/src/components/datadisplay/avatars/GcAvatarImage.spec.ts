// Unit test for GcAvatar component

import { mount } from '@vue/test-utils'
import GcAvatar from '@/components/datadisplay/avatars/GcAvatarImage.vue'

describe('GcAvatarImage.vue', () => {
    it('renders image when passed', () => {
        const src = 'https://avatars.githubusercontent.com/u/5503835?v=4'
        const wrapper = mount(GcAvatar, {
            props: { src },
        })
        const image = wrapper.find('img');
        expect(image.exists()).toBe(true);
        expect(image.attributes().src).toBe(src);
    });

    it('when given image and name it uses the name as alt text', () => {
        const src = 'https://avatars.githubusercontent.com/u/5503835?v=4'
        const name = 'Durel Linux'
        const wrapper = mount(GcAvatar, {
            props: { src, name },
        })
        const image = wrapper.find('img');
        expect(image.attributes().alt).toBe(name);
    });

    it('when given image and no name it uses "Image" as alt text', () => {
        const src = 'https://avatars.githubusercontent.com/u/5503835?v=4'
        const wrapper = mount(GcAvatar, {
            props: { src },
        })
        const image = wrapper.find('img');
        expect(image.attributes().alt).toBe('Image');
    });
});

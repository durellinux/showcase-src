// Unit tests for GcButtonPrimary

import { mount } from '@vue/test-utils';
import GcButtonPrimary from '@/components/inputs/buttons/GcButtonFilled.vue';

describe('GcButtonFilled.vue', () => {
    it('Show a simple text when passed as slot', () => {
        const wrapper = mount(GcButtonPrimary, {
        slots: {
            default: 'Hello Button',
        },
        });
        expect(wrapper.text()).toMatch('Hello Button');
    });

    it('Show a complex html element when passed in slot', () => {
        const wrapper = mount(GcButtonPrimary, {
        slots: {
            default: '<span>Hello Button</span>',
        },
        });
        expect(wrapper.text()).toMatch('Hello Button');
    });

    it('When clicked emit a click event', async () => {
        const wrapper = mount(GcButtonPrimary);
        await wrapper.trigger('click');
        expect(wrapper.emitted('click')).toBeTruthy();
    });

    it('When disabled do not emit a click event', async () => {
        const wrapper = mount(GcButtonPrimary, {
        props: {
            disabled: true,
        },
        });
        await wrapper.trigger('click');
        expect(wrapper.emitted('click')).toBeFalsy();
    });
});

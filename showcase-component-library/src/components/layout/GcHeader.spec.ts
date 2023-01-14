// Tests for GcHeader component

import { mount } from '@vue/test-utils';
import GcHeader from './GcHeader.vue';

describe('GcHeader', () => {
    test('Renders title slot', () => {
        const wrapper = mount(GcHeader, {
            slots: {
                title: 'Title',
            },
        });
        expect(wrapper.text()).toContain('Title');
    });

    test('Renders Actions slot', () => {
        const wrapper = mount(GcHeader, {
            slots: {
                actions: 'Actions',
            },
        });
        expect(wrapper.text()).toContain('Actions');
    });

    test('Renders complex title slot', () => {
        const wrapper = mount(GcHeader, {
            slots: {
                title: '<span>Complex</span> <span>title</span>',
            },
        });
        expect(wrapper.text()).toContain('Complex title');
    });

    test('Renders complex Actions slot', () => {
        const wrapper = mount(GcHeader, {
            slots: {
                actions: '<span>Complex</span> <span>actions</span>',
            },
        });
        expect(wrapper.text()).toContain('Complex actions');
    });

    test('Matches snapshot', () => {
        const wrapper = mount(GcHeader, {
            slots: {
                title: 'Title',
                actions: 'Actions',
            },
        });
        expect(wrapper.element).toMatchSnapshot();
    });
});

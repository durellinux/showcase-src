// Unit tests for Autocomplete component

import { mount } from '@vue/test-utils'
import Autocomplete from './Autocomplete.vue'

describe('Autocomplete', () => {
    test('is a Vue instance', () => {
        const wrapper = mount(Autocomplete)
        expect(wrapper.vm).toBeTruthy()
    });

    test('renders correctly', () => {
        const wrapper = mount(Autocomplete)
        expect(wrapper.element).toMatchSnapshot()
    });

    test('renders correctly with props', () => {
        const wrapper = mount(Autocomplete, {
            props: {
                items: ['item1', 'item2', 'item3'],
                value: 'item1',
            }
        })
        expect(wrapper.element).toMatchSnapshot()
    });

    test('renders correctly with props and slots', () => {
        const wrapper = mount(Autocomplete, {
            props: {
                items: ['item1', 'item2', 'item3'],
                value: 'item1',
            },
            slots: {
                default: 'Hello world',
            }
        })
        expect(wrapper.element).toMatchSnapshot()
    });

    test('renders correctly with props and slots and scoped slots', () => {
        const wrapper = mount(Autocomplete, {
            props: {
                items: ['item1', 'item2', 'item3'],
                value: 'item1',
            },
            slots: {
                default: 'Hello world',
            },
            scopedSlots: {
                item: '<div>{{ props.item }}</div>',
            }
        })
        expect(wrapper.element).toMatchSnapshot()
    });
});

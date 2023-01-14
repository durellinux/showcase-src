// Unit test of the GcButton component

import { mount } from '@vue/test-utils';
import GcButton from '@/components/inputs/buttons/GcButtonBase.vue';

describe('GcButtonBase.vue', () => {
  it('Show a simple text when passed as slot', () => {
    const wrapper = mount(GcButton, {
      slots: {
        default: 'Hello Button',
      },
    });
    expect(wrapper.text()).toMatch('Hello Button');
  });

  it('Show a complex html element when passed in slot', () => {
    const wrapper = mount(GcButton, {
      slots: {
        default: '<span>Hello Button</span>',
      },
    });
    expect(wrapper.text()).toMatch('Hello Button');
  });

  it('When clicked emit a click event', async () => {
    const wrapper = mount(GcButton);
    await wrapper.trigger('click');
    expect(wrapper.emitted('click')).toBeTruthy();
  });

  it('When disabled do not emit a click event', async () => {
    const wrapper = mount(GcButton, {
      props: {
        disabled: true,
      },
    });
    await wrapper.trigger('click');
    expect(wrapper.emitted('click')).toBeFalsy();
  });
});

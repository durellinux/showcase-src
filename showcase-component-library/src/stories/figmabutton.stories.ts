import { Story } from "@storybook/vue3";
import { ButtonProps } from "@/components/buttons/ButtonProps";
import { DsButton } from "@/components";
import { withDesign } from "storybook-addon-designs";

function figmaStory<T>(
  template: Story<T>,
  args: T,
  figmaLink: string
): Story<T> {
  const story = template.bind({});
  story.args = { ...args };
  story.parameters = {
    design: {
      type: "figma",
      url: figmaLink,
    },
  };
  return story;
}

export default {
  title: "Figma/Buttons",
  component: DsButton,
  decorators: [withDesign],
};

const Template: Story<ButtonProps> = (args: ButtonProps) => ({
  components: { DsButton },
  setup() {
    return { args };
  },
  template: '<ds-button v-bind="args" />',
});

export const Contained = figmaStory<ButtonProps>(
  Template,
  { variant: "contained", label: "button" },
  "https://www.figma.com/file/GqqpunkXUd73J20rtExdHl/Design-System?node-id=6%3A212&t=7Dl1CmmNdHQKDqNG-4"
);

export const Outlined = () => ({
  components: { DsButton },
  template: '<ds-button label="button" variant="outlined" />',
});

export const Text = () => ({
  components: { DsButton },
  template: '<ds-button label="button" variant="text" />',
});

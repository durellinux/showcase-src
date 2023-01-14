module.exports = {
  preset: '@vue/cli-plugin-unit-jest/presets/typescript',
  testMatch: ["**/components/**/*.spec.[jt]s?(x)"],
  transform: {
    '^.+\\.vue$': 'vue-jest'
  }
}

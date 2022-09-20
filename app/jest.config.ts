export default {
  preset: "ts-jest",
  testEnvironment: "node",
  coveragePathIgnorePatterns: ["<rootDir>/.*.(stories|test).(js|jsx|ts|tsx)$"],
  resetMocks: true,
  clearMocks: true,
};

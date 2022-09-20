import { validateEquation } from "./equation-validator";

describe("Equation validator", () => {
  test.each([
    ["1 + 2 = 3", "valid"],
    ["2 + 1 = 3", "valid"],
    ["1+2=3", "valid"],
    ["1 + 2 = 5", "invalid"],
    ["2 + 1 = 5", "invalid"],
    ["1+2=5", "invalid"],
    ["not an equation", "syntax error"],
    ["", "syntax error"],
    ["1 + 2 + 3 = 6", "syntax error"],
    ["1 - 2 = 3", "syntax error"],
    ["2 - 1 = 1", "syntax error"],
    ["2-1=1", "syntax error"],
    ["a + b = c", "syntax error"],
    ["a+b=c", "syntax error"],
  ])(
    "when equation is '%s', result should be '%s'",
    (equation, expectedResult) => {
      const result = validateEquation(equation);
      expect(result).toBe(expectedResult);
    }
  );
});

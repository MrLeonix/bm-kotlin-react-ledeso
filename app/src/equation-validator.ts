const validateEquation = (equationString: string) => {
  const equationRegExMatcher = /^(\d+)\s*\+\s*(\d+)\s*\=\s*(\d+)$/;
  const regExMatch = equationString.match(equationRegExMatcher);

  if (!regExMatch) return "syntax error";

  const equationFirst = parseInt(regExMatch[1]);
  const equationSecond = parseInt(regExMatch[2]);
  const equationResult = parseInt(regExMatch[3]);

  if (equationFirst + equationSecond !== equationResult) return "invalid";

  return "valid";
};

export { validateEquation };

# React Equation Validator Application

## Tests

To run tests, run the following command:

```
npm test
```

An input similar to this should display:
```
> app@1.0.0 test
> jest

 PASS  src/equation-validator.test.ts
  Equation validator
    ✓ when equation is '1 + 2 = 3', result should be 'valid' (1 ms)
    ✓ when equation is '2 + 1 = 3', result should be 'valid'
    ✓ when equation is '1+2=3', result should be 'valid'
    ✓ when equation is '1 + 2 = 5', result should be 'invalid'
    ✓ when equation is '2 + 1 = 5', result should be 'invalid' (1 ms)
    ✓ when equation is '1+2=5', result should be 'invalid'
    ✓ when equation is 'not an equation', result should be 'syntax error'
    ✓ when equation is '', result should be 'syntax error'
    ✓ when equation is '1 + 2 + 3 = 6', result should be 'syntax error' (1 ms)
    ✓ when equation is '1 - 2 = 3', result should be 'syntax error'
    ✓ when equation is '2 - 1 = 1', result should be 'syntax error'
    ✓ when equation is '2-1=1', result should be 'syntax error'
    ✓ when equation is 'a + b = c', result should be 'syntax error'
    ✓ when equation is 'a+b=c', result should be 'syntax error' (1 ms)

Test Suites: 1 passed, 1 total
Tests:       14 passed, 14 total
Snapshots:   0 total
Time:        1.021 s
Ran all test suites.
```
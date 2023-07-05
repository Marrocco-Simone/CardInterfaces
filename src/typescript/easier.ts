// https://stackoverflow.com/questions/42123407/does-typescript-support-mutually-exclusive-types
type Without<T, U> = { [P in Exclude<keyof T, keyof U>]?: never };
type XOR<T, U> = T | U extends object
  ? (Without<T, U> & U) | (Without<U, T> & T)
  : T | U;

// ! GENERIC INTERFACES

type ActionCard = {
  fire: () => void;
};

type GameInput = {};

type DescriptionCard = {
  fire: (card: string) => boolean;
};

type StateCardInput<T extends GameInput> = {
  stateInput: T;
  descriptions: DescriptionCard[];
};

type StateCard<T extends GameInput> = {
  fire: (i: StateCardInput<T>) => boolean;
};

// type LogicCardInput<T extends GameInput> = {
//   left: XOR<LogicCard<T>, StateCard<T>>;
//   leftInput: XOR<LogicCardInput<T>, StateCardInput<T>>;
//   right: XOR<LogicCard<T>, StateCard<T>>;
//   rightInput: XOR<LogicCardInput<T>, StateCardInput<T>>;
// };
type LogicCardInput<T extends GameInput> = XOR<
  {
    left: LogicCard<T>;
    leftInput: LogicCardInput<T>;
  },
  {
    left: StateCard<T>;
    leftInput: StateCardInput<T>;
  }
> &
  XOR<
    {
      right: LogicCard<T>;
      rightInput: LogicCardInput<T>;
    },
    {
      right: StateCard<T>;
      rightInput: StateCardInput<T>;
    }
  >;

type LogicCard<T extends GameInput> = {
  fire: (i: LogicCardInput<T>) => boolean;
};

// ! SMARTER BLOCKS

type SmarterInput = {
  state: string[];
  inserted: number;
} & GameInput;

const SYMBOLS: string[] = ["<", ">", "=", ">=", "<+"];

class SymbolCard implements DescriptionCard {
  fire = (card: string) => SYMBOLS.includes(card);

  constructor() {}
}

class NumericCard implements DescriptionCard {
  fire = (card: string) => !isNaN(parseInt(card));

  constructor() {}
}

class OnLeftCard implements StateCard<SmarterInput> {
  fire = (i: StateCardInput<SmarterInput>) => {
    const inputLeft = i.stateInput.state.slice(0, i.stateInput.inserted);

    let result = false;
    for (const inputLeftCard of inputLeft) {
      for (const descr of i.descriptions) {
        result = result || descr.fire(inputLeftCard);
      }
    }
    return result;
  };

  constructor() {}
}

class OnRightCard implements StateCard<SmarterInput> {
  fire = (i: StateCardInput<SmarterInput>) => {
    const inputRight = i.stateInput.state.slice(
      i.stateInput.inserted + 1,
      undefined
    );

    let result = false;
    for (const inputRightCard of inputRight) {
      for (const descr of i.descriptions) {
        result = result || descr.fire(inputRightCard);
      }
    }
    return result;
  };

  constructor() {}
}

class AndCard implements LogicCard<SmarterInput> {
  fire = (i: LogicCardInput<SmarterInput>) =>
    // @ts-ignore
    i.left.fire(i.leftInput) && i.right.fire(i.rightInput);

  constructor() {}
}

// ! MAIN

function main() {
  const stateInput: SmarterInput = {
    state: ["2", "3", "=", "4", ">"],
    inserted: 2,
  };
  let b;

  b = new AndCard().fire({
    left: new OnLeftCard(),
    leftInput: {
      stateInput,
      descriptions: [new NumericCard()],
    },
    right: new OnRightCard(),
    rightInput: {
      stateInput,
      descriptions: [new SymbolCard()],
    },
  });
  console.log(b);

  b = new AndCard().fire({
    left: new AndCard(),
    leftInput: {
      left: new OnLeftCard(),
      leftInput: {
        stateInput,
        descriptions: [new NumericCard()],
      },
      right: new OnRightCard(),
      rightInput: {
        stateInput,
        descriptions: [new NumericCard()],
      },
    },
    right: new OnRightCard(),
    rightInput: {
      stateInput,
      descriptions: [new SymbolCard()],
    },
  });
  console.log(b);
}
main();

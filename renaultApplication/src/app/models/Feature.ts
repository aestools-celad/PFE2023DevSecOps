export interface Feature {
  type: String;
  geometry: {
    type: String;
    coordinates: number[];
  };
  properties: {
    name: String;
    address: String;
    // add any other properties you need
  };
}
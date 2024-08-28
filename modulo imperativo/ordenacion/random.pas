program randomEje;
const
  min=10;
  max=255;
begin 
  randomize();
  writeln(random(max-min+1)+min); // rango [10,255]
end.

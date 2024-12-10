import React from "react";

interface ControlPanelProps {
  onStart: () => void;
  onStop: () => void;
  onReset: () => void;
}

const ControlPanel: React.FC<ControlPanelProps> = ({
  onStart,
  onStop,
  onReset,
}) => {
  return (
    <div>
      <h2>Control Panel</h2>
      <button onClick={onStart}>Start</button>
      <button onClick={onStop}>Stop</button>
      <button onClick={onReset}>Reset</button>
    </div>
  );
};

export default ControlPanel;

import React from "react";

interface ControlPanelProps {
  isRunning: boolean;
  onStart: () => void;
  onStop: () => void;
}

function ControlPanel({ onStart, onStop }: ControlPanelProps) {
  const handleStart = async () => {
    try {
      const response = await fetch("http://localhost:8080/ticketing/start", {
        method: "POST",
      });
      const message = await response.text();
      console.log(message);
      onStart();
    } catch (error) {
      console.error("Error starting simulation:", error);
    }
  };

  const handleStop = async () => {
    try {
      const response = await fetch("http://localhost:8080/ticketing/stop", {
        method: "POST",
      });
      const message = await response.text();
      console.log(message);
      onStop();
    } catch (error) {
      console.error("Error stopping simulation:", error);
    }
  };

  return (
    <div className="control-panel">
      <h2>Control Panel</h2>
      <button onClick={handleStart}>Start</button>
      <button onClick={handleStop}>Stop</button>
    </div>
  );
}

export default ControlPanel;

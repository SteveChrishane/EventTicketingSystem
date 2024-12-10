interface ControlPanelProps {
  isRunning: boolean;
  onStart: () => void;
  onStop: () => void;
  onReset: () => void;
}

function ControlPanel({
  isRunning,
  onStart,
  onStop,
  onReset,
}: ControlPanelProps) {
  return (
    <div className="control-panel">
      <h2>Control Panel</h2>
      <button onClick={onStart} disabled={isRunning}>
        Start
      </button>
      <button onClick={onStop} disabled={!isRunning}>
        Stop
      </button>
      <button onClick={onReset}>Reset</button>
    </div>
  );
}

export default ControlPanel;

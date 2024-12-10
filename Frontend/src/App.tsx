import React, { useState } from "react";
import ConfigurationForm from "./components/ConfigurationForm";
import TicketStatus from "./components/TicketStatus";
import ControlPanel from "./components/ControlPanel";
import LogDisplay from "./components/LogDisplay";

const App: React.FC = () => {
  const [config, setConfig] = useState({
    totalTickets: 100,
    releaseRate: 1000,
    retrievalRate: 500,
    maxCapacity: 200,
  });
  const [availableTickets, setAvailableTickets] = useState(config.totalTickets);
  const [logs, setLogs] = useState<string[]>([]);

  const handleSaveConfig = (newConfig: typeof config) => {
    setConfig(newConfig);
    setAvailableTickets(newConfig.totalTickets);
    setLogs([...logs, "Configuration updated."]);
  };

  const handleStart = () => setLogs([...logs, "Simulation started."]);
  const handleStop = () => setLogs([...logs, "Simulation stopped."]);
  const handleReset = () => {
    setAvailableTickets(config.totalTickets);
    setLogs([...logs, "Simulation reset."]);
  };

  return (
    <div>
      <h1>Real-Time Event Ticketing System</h1>
      <ConfigurationForm onSave={handleSaveConfig} />
      <TicketStatus
        availableTickets={availableTickets}
        maxCapacity={config.maxCapacity}
      />
      <ControlPanel
        onStart={handleStart}
        onStop={handleStop}
        onReset={handleReset}
      />
      <LogDisplay logs={logs} />
    </div>
  );
};

export default App;
